/**
 * 
 */
package com.students.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Digits(integer=3, fraction=0)
	@Min(100)
	@Max(999)
 	private Integer area;

	@NotNull
	@Digits(integer=3, fraction=0)
	@Min(100)
	@Max(999)
 	private Integer prefix;

	@NotNull
	@Digits(integer=4, fraction=0)
	@Min(1000)
	@Max(9999)
 	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
