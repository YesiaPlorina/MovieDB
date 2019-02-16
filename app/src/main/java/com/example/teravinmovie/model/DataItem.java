package com.example.teravinmovie.model;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("overview")
	private String overview;

	@SerializedName("id_film")
	private String idFilm;

	@SerializedName("rating")
	private String rating;

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("judul")
	private String judul;

	@SerializedName("gambar")
	private String gambar;

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setIdFilm(String idFilm){
		this.idFilm = idFilm;
	}

	public String getIdFilm(){
		return idFilm;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}
}