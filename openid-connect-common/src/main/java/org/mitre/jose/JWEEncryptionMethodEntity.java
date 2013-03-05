/**
 * 
 */
package org.mitre.jose;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.google.common.base.Strings;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;

/**
 * @author jricher
 *
 */
@Embeddable
public class JWEEncryptionMethodEntity {

	private EncryptionMethod algorithm;

	public JWEEncryptionMethodEntity() {
		
	}
	
	public JWEEncryptionMethodEntity(EncryptionMethod algorithm) {
	    this.algorithm = algorithm;
    }

	public static JWEEncryptionMethodEntity getForAlgorithmName (String algorithmName) {
		JWEEncryptionMethodEntity ent = new JWEEncryptionMethodEntity();
		ent.setAlgorithmName(algorithmName);
		if (ent.getAlgorithm() == null) {
			return null;
		} else {
			return ent;
		}
	}
	
	/**
	 * Get the name of this algorithm, return null if no algorithm set.
	 * @return
	 */
	@Basic
	public String getAlgorithmName() {
		if (algorithm != null) {
			return algorithm.getName();
		} else {
			return null;
		}
	}
	
	/**
	 * Set the name of this algorithm. 
	 * Calls EncryptionMethod.parse()
	 * @param algorithmName
	 */
	public void setAlgorithmName(String algorithmName) {
		if (!Strings.isNullOrEmpty(algorithmName)) {
			algorithm = EncryptionMethod.parse(algorithmName);
		} else {
			algorithm = null;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "JWEEncryptionMethodEntity [algorithm=" + algorithm + "]";
    }

	/**
	 * @return the algorithm
	 */
    @Transient
	public EncryptionMethod getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(EncryptionMethod algorithm) {
		this.algorithm = algorithm;
	}
	

}