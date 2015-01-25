package com.hascode.tutorial.rest;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import com.google.gson.Gson;
import com.hascode.tutorial.rest.transfer.UserTransfer;
import com.sun.jersey.api.representation.Form;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

public class UserServiceTest extends JerseyTest {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

    String token;

//    @Test
//    public void addUserTest() {
//        target("users/add").request().post(userEntity); //Here we send POST request
//        Response response = target("users/find").queryParam("email", "user2@mail.com").request().get(); //Here we send GET request for retrieving results
//        Assert.assertEquals("user2@mail.com", response.readEntity(User.class).getEmail());
//
//    }

    public String getAuthenticateSuccess(String name, String password) throws JSONException,
            URISyntaxException {

        Form form = new Form();
        form.add("password", password);
        form.add("username", name);

        WebResource webResource = client().resource("http://localhost:8080");
        JSONObject json = webResource.path("/rest/user/authenticate")
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .accept("application/json")
                .type("application/json")
                .post(JSONObject.class,form);

        // {"token":"user:1422212552794:f4f95e1ec6c9a30de30d57e6ba2063db"}

        return (String) json.get("token");
    }

	@Test
	public void testUserFetchesSuccess() throws JSONException,
			URISyntaxException {
        String authToken = getAuthenticateSuccess("user", "user");
		WebResource webResource = client().resource("http://localhost:8080/");
		JSONObject json = webResource.path("/rest/user")
                .header("X-Auth-Token", authToken)
				.get(JSONObject.class);

        Gson gson = new Gson();
        UserTransfer result = gson.fromJson(json.toString(), UserTransfer.class);

		assertEquals("user", result.getName());
        assertEquals(1, result.getRoles().size());

	}

	@Test(expected = UniformInterfaceException.class)
	public void testUserNotFound() {
		WebResource webResource = client().resource("http://localhost:8080/");
		JSONObject json = webResource.path("/rest-test-tutorial/user/id/666")
				.get(JSONObject.class);
	}
}
