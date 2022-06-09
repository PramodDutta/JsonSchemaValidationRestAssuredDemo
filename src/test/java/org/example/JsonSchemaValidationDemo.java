package org.example;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class JsonSchemaValidationDemo
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void jsonSchemaValidation()
    {
        RestAssured.baseURI = "https://reqres.in";
        String response = RestAssured
                .given()
                .when().get("/api/users/2")
                .getBody().asString();
        assertThat( response, matchesJsonSchemaInClasspath("userSchema.json"));


    }
}
