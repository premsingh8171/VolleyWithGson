package com.premsinghdaksha.volleyautomationparsing.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataResponse implements Serializable {

	@SerializedName("studio")
	private String studio;

	@SerializedName("img")
	private String img;

	@SerializedName("categorie")
	private String categorie;

	@SerializedName("Rating")
	private String rating;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("episode")
	private int episode;

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

	public void setCategorie(String categorie){
		this.categorie = categorie;
	}

	public String getCategorie(){
		return categorie;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setEpisode(int episode){
		this.episode = episode;
	}

	public int getEpisode(){
		return episode;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"studio = '" + studio + '\'' + 
			",img = '" + img + '\'' + 
			",categorie = '" + categorie + '\'' + 
			",rating = '" + rating + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",episode = '" + episode + '\'' + 
			"}";
		}
}