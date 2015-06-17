package com.bitdubai.fermat_p2p_api.layer.p2p_communication;

import java.io.IOException;

/**
 * Created by ciencias on 31.12.14.
 */
public class CommunicationException extends IOException {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 6617598263430521619L;

	public CommunicationException(){
		super();
	}

	public CommunicationException(final String message){
		super(message);
	}

}