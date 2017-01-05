package utils;

public class Prodotto {
	
	String nome, SN, imglnk, tipo, marca, db, dl, lnk; 
	double prezzo; 
	int num, id;
	
	public Prodotto(int id, String nome, String SN, String imglnk, double prezzo, String tipo, String marca, String db, String dl, String lnk, int num){
		this.id = id;
		this.nome = nome;
		this.SN = SN;
		this.imglnk = imglnk;
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.marca = marca;
		this.db = db;
		this.dl = dl;
		this.lnk = lnk;
		this.num = num;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
