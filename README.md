# VolleyWithGson
<img src="https://github.com/premsingh8171/VolleyWithGson/blob/master/app/src/main/res/drawable/header.png"/>

<img class="marginauto" alt="centered image" src="https://github.com/premsingh8171/VolleyWithGson/blob/master/app/src/main/res/drawable/one.png" width="300" height="550" /> <img src="https://github.com/premsingh8171/VolleyWithGson/blob/master/app/src/main/res/drawable/two.png" width="300" height="550" />

<h1>Setup</H1>

1. ADD NETWOK PERMISISON
```
<uses-permission android:name="android.permission.INTERNET" />
```
```
dependencies {

     implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
     implementation 'com.android.volley:volley:1.1.1'
}
```
2. Define the Model
```JAVA
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataResponse implements Serializable {

	@SerializedName("studio")
	private String studio;

	@SerializedName("img")
	private String img;

	public void setStudio(String studio){
		this.studio = studio;
	}

	public String getStudio(){
		return studio;
	}

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return img;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"studio = '" + studio + '\'' + 
			",img = '" + img + '\'' + 
			"}";
		}
}
```

3.Making the Request

```JAVA
    private void volleyAutomation(String url) {
        JSONArray array = new JSONArray();
        JsonArrayRequest request_json = new JsonArrayRequest(Request.Method.GET, url, array,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        dataResponses = Arrays.asList(gson.fromJson(response.toString(), DataResponse[].class));
                        //  DataResponse response1 = gson.fromJson(String.valueOf(response), DataResponse.class);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request_json);
    }

```



<h2>Created and maintained by:</h2>
<p>Er.Prem singh daksha  premsingh8171@gmail.com</p>
<p><a href="https://www.linkedin.com/in/prem-singh-daksha-82az/"> <img src="https://github.com/anitaa1990/DeviceInfo-Sample/blob/master/media/linkedin-icon.png" alt="Linkedin" style="max-width:100%;"> </a></p>

