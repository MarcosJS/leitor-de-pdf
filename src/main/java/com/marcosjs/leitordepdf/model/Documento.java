package com.marcosjs.leitordepdf.model;

public abstract class Documento {
	private String md5;
	private String nomeDocumento;
	
	/********************************************************************
	 *                          CONSTRUTORES                            *
	 ********************************************************************/
	/**
	 * 
	 
	public Documento() {
		setMd5(null);
		setNomeDocumento(null);
	}*/

	/********************************************************************
	 *                              METODOS                             *
	 ********************************************************************/
	/**
	 * @return
	 */
	public String getMd5() {
		return md5;
	}
	
	/**
	 * @param md5
	 */
	protected void setMd5(String md5) {
		this.md5 = md5;
	}

	/**
	 * @return the nomeDocumento
	 */
	public String getNomeDocumento() {
		return nomeDocumento;
	}

	/**
	 * @param nomeDocumento the nomeDocumento to set
	 */
	protected void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

}
