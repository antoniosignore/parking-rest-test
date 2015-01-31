package com.parking.rest;

import com.google.gson.Gson;
import com.parking.rest.dto.UserTransfer;
import com.parking.rest.entity.Account;
import com.parking.rest.entity.Post;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PostServiceTest extends ParkingTest {

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

	@Test
	public void testCreatePostSuccess() throws JSONException, URISyntaxException {

        String authToken = getToken("admin", "admin");

        WebResource webResource = client().resource("http://localhost:8080/parking");
        JSONObject json = webResource.path("/rest/account")
                .header("X-Auth-Token", authToken)
                .get(JSONObject.class);

        Gson gson = new Gson();
        UserTransfer result = gson.fromJson(json.toString(), UserTransfer.class);

        assertEquals("admin", result.getName());
        assertEquals(2, result.getRoles().size());

        Post post = new Post();
        post.setContent("xxxxxxxxxxx");
        post.setTitle("my title");

        webResource = client().resource("http://localhost:8080/parking");
        String post1 = webResource.path("/rest/account/" + "admin" + "/post")
                .header("X-Auth-Token", authToken)
                .accept("application/json")
                .type("application/json")
                .post(String.class, gson.toJson(post));

        System.out.println("post1 = " + post1);

        webResource = client().resource("http://localhost:8080/parking");
        post1 = webResource.path("/rest/post")
                .header("X-Auth-Token", authToken)
                .accept("application/json")
                .type("application/json")
                .get(String.class);

        System.out.println("post1 = " + post1);

//        JSONObject post1 = webResource.path("/rest/account/" + "admin" + "/post")
//                .header("X-Auth-Token", authToken)
//                .accept("application/json")
//                .type("application/json")
//                .post(JSONObject.class, post);
//
//        System.out.println("post1 = " + post1);
//
//        System.out.println("post1.get(id) = " + post1.get("id"));
//        assertEquals("my title", post1.get("title"));
//        assertEquals("xxxxxxxxxxx", post1.get("content"));
    }
}
