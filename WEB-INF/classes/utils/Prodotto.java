package utils;

public class Prodotto {
	
	String nome, SN, imglnk, tipo, marca, db, dl, lnk; 
	float prezzo; 
	int num;
	
	public Prodotto(String nome, String SN, String imglnk, float prezzo, String tipo, String marca, String db, String dl, String lnk, int num){
		nome = this.nome;
		SN = this.SN;
		imglnk = this.imglnk;
		prezzo = this.prezzo;
		tipo = this.tipo;
		marca = this.marca;
		db = this.db;
		dl = this.dl;
		lnk = this.lnk;
		num = this.num;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getImglnk() {
		return imglnk;
	}

	public void setImglnk(String imglnk) {
		this.imglnk = imglnk;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getDl() {
		return dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getLnk() {
		return lnk;
	}

	public void setLnk(String lnk) {
		this.lnk = lnk;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}
