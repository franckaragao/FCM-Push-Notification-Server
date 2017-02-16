package br.edu.ifpb.mt.fcm;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class FirebaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("multicast_id")
	private Object multicastId;

	@JsonProperty("success")
	private Integer success;

	@JsonProperty("failure")
	private Integer failure;

	@JsonProperty("canonical_ids")
	private Integer canonicalIds;

	@JsonProperty("results")
	private List<Object> results;

	public FirebaseResponse() {

	}

	public Object getMulticastId() {
		return multicastId;
	}

	public void setMulticastId(Object multicastId) {
		this.multicastId = multicastId;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getFailure() {
		return failure;
	}

	public void setFailure(Integer failure) {
		this.failure = failure;
	}

	public Integer getCanonicalIds() {
		return canonicalIds;
	}

	public void setCanonicalIds(Integer canonicalIds) {
		this.canonicalIds = canonicalIds;
	}

	public List<Object> getResults() {
		return results;
	}

	public void setResults(List<Object> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "FirebaseResponse [multicastId=" + multicastId + ", success=" + success + ", failure=" + failure
				+ ", canonicalIds=" + canonicalIds + ", results=" + results + "]";
	}
	
	

}
