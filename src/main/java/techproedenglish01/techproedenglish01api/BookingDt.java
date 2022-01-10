package techproedenglish01.techproedenglish01api;


	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;
	/*
	 * When you create a POJO Class ,it should have;
	 *1-private variables
	 *2-getter(),setter() methods for all variables
	 *3-Constructor with all parameters  after this eclips help me
	 *4-Constructor with all parameters
	 *5-toString()
	 *
	 *After that we check one by one 
	 */
	public class BookingDt {

	@SerializedName("firstname")
	@Expose
	private String firstname;
	@SerializedName("lastname")
	@Expose
	private String lastname;
	@SerializedName("totalprice")
	@Expose
	private Integer totalprice;
	@SerializedName("depositpaid")
	@Expose
	private Boolean depositpaid;
	@SerializedName("bookingdates")
	@Expose
	private BookingDatesDt bookingdates;
	@SerializedName("additionalneeds")
	@Expose
	private String additionalneeds;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public Boolean getDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(Boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public BookingDatesDt getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDatesDt bookingdates) {
		this.bookingdates = bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	public BookingDt(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
			BookingDatesDt bookingdates, String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}

	public BookingDt() {// we deleted super()
	}

	@Override
	public String toString() {
		return "BookingDt [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
				+ additionalneeds + "]";
	}

	}

