package test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class APITest1 {
    @Test
    public void apiTest1() {
        RequestSpecification request = given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .queryParam("drilldowns", "State").queryParam("measures", "Population")
                .queryParam("year", "latest");

        Response response = request.when().get(APIConstants.BaseURI);
        //System.out.println(response.prettyPrint());

        JsonElement fullPageElement = new JsonParser().parse(response.asString());
        JsonObject fullPageObject = fullPageElement.getAsJsonObject();
        JsonElement dataElements = fullPageObject.get("data");

        JsonArray arrayOfData = dataElements.getAsJsonArray();
        int sizeOfDataArray = arrayOfData.size();

        List<String> yearList = new ArrayList<>();
        List<String> stateList = new ArrayList<>();

        for (int i = 0; i < sizeOfDataArray; i++) {
            JsonElement allUsersInfo = arrayOfData.get(i);
            JsonObject eachUserInfo = allUsersInfo.getAsJsonObject();
            yearList.add(eachUserInfo.get("Year").getAsString());
            stateList.add(eachUserInfo.get("State").getAsString());
        }

        Set<String> yearSet = new HashSet<>(yearList);
        Set<String> stateSet = new HashSet<>(stateList);

        Assert.assertEquals(yearSet.size(),1);
        Assert.assertEquals(stateList.size(),stateSet.size());

        System.out.println("API TEST DONE!!!");
    }
}
