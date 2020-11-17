package model;

public class Item {
	private String titulo;
	private String url;
	private String[] seo;
	private String descripcion;
	
	
	public Item(String titulo, String url, String[] seo, String descripcion) {
		super();
		this.titulo = titulo;
		this.url = url;
		this.seo = seo;
		this.descripcion = descripcion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String[] getSeo() {
		return seo;
	}
	
	public void setSeo(String[] seo) {
		this.seo = seo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
