package com.marcosjs.leitordepdf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class DocumentoPdf extends Documento{
	private PDDocument pddocumento;
	private PDFTextStripper stripper;
	private String textoPdf;
	
	/********************************************************************
	 *                          CONSTRUTORES                            *
	 ********************************************************************/
	/**
	 * @throws IOException
	 */
	public DocumentoPdf() throws IOException {
		this.pddocumento = new PDDocument();
		this.stripper = new PDFTextStripper();
		this.textoPdf = null;
	 }
	
	/**
	 * @param file
	 * @throws IOException
	 */
	public DocumentoPdf(File file) throws IOException {
		this.pddocumento = PDDocument.load(file);
	    this.stripper = new PDFTextStripper();
	    this.textoPdf = this.stripper.getText(pddocumento).toString();
	    this.pddocumento.close();
	    super.setMd5(DigestUtils.md5Hex(new FileInputStream(file)));
	    super.setNomeDocumento(file.getName());
	}
	
	/**
	 * @param input
	 * @param nomeDocumento
	 * @throws IOException  
	 */
	public DocumentoPdf(InputStream input, String nomeDocumento) throws IOException  {
		try {
			if(input != null) {
				throw new Exception(nomeDocumento);
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.pddocumento = PDDocument.load(input);
		this.stripper = new PDFTextStripper();
	    this.textoPdf = this.stripper.getText(pddocumento).toString();
	    this.pddocumento.close();
	    super.setMd5(DigestUtils.md5Hex(input));
	    super.setNomeDocumento(nomeDocumento);
	}
	
	/********************************************************************
	 *                              METODOS                             *
	 ********************************************************************/
	/**
	 * @param input
	 * @param nomeDocumento
	 * @throws IOException
	 */
	public void carregarDocumento(InputStream input, String nomeDocumento) throws IOException {
		this.pddocumento = PDDocument.load(input);
		this.textoPdf = this.stripper.getText(pddocumento).toString();
	    this.pddocumento.close();
	    super.setMd5(DigestUtils.md5Hex(input));
	    super.setNomeDocumento(nomeDocumento);
	}
	
	/**
	 * @param file
	 * @throws IOException
	 */
	public void carregarDocumento(File file) throws IOException {
		this.pddocumento = PDDocument.load(file);
		this.textoPdf = this.stripper.getText(pddocumento).toString();
	    this.pddocumento.close();
	    super.setMd5(DigestUtils.md5Hex(new FileInputStream(file)));
	    super.setNomeDocumento(file.getName());
	}

	/**
	 * @return
	 */
	public String getTextoPdf() {
		return this.textoPdf;
	}
	
	/**
	 * @return
	 */
	public String[] getTextoPdfPorLinhas() {
		return this.getTextoPdf().split("\n");
	}
}
