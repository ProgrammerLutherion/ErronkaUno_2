package model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the payment_transaction database table.
 * 
 */
@Entity
@Table(name="payment_transaction")
@NamedQuery(name="PaymentTransaction.findAll", query="SELECT p FROM PaymentTransaction p")
public class PaymentTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="acquirer_id")
	private Integer acquirerId;

	@Column(name="acquirer_reference")
	private String acquirerReference;

	private BigDecimal amount;

	@Column(name="callback_hash")
	private String callbackHash;

	@Column(name="callback_method")
	private String callbackMethod;

	@Column(name="callback_model_id")
	private Integer callbackModelId;

	@Column(name="callback_res_id")
	private Integer callbackResId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="currency_id")
	private Integer currencyId;

	private Timestamp date;

	private BigDecimal fees;

	@Column(name="html_3ds")
	private String html3ds;

	@Column(name="is_processed")
	private Boolean isProcessed;

	@Column(name="partner_address")
	private String partnerAddress;

	@Column(name="partner_city")
	private String partnerCity;

	@Column(name="partner_country_id")
	private Integer partnerCountryId;

	@Column(name="partner_email")
	private String partnerEmail;

	@Column(name="partner_lang")
	private String partnerLang;

	@Column(name="partner_name")
	private String partnerName;

	@Column(name="partner_phone")
	private String partnerPhone;

	@Column(name="partner_zip")
	private String partnerZip;

	@Column(name="payment_id")
	private Integer paymentId;

	@Column(name="payment_token_id")
	private Integer paymentTokenId;

	private String reference;

	@Column(name="return_url")
	private String returnUrl;

	private String state;

	@Column(name="state_message")
	private String stateMessage;

	private String type;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_id")
	private ResPartner resPartner;

	public PaymentTransaction() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcquirerId() {
		return this.acquirerId;
	}

	public void setAcquirerId(Integer acquirerId) {
		this.acquirerId = acquirerId;
	}

	public String getAcquirerReference() {
		return this.acquirerReference;
	}

	public void setAcquirerReference(String acquirerReference) {
		this.acquirerReference = acquirerReference;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCallbackHash() {
		return this.callbackHash;
	}

	public void setCallbackHash(String callbackHash) {
		this.callbackHash = callbackHash;
	}

	public String getCallbackMethod() {
		return this.callbackMethod;
	}

	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	public Integer getCallbackModelId() {
		return this.callbackModelId;
	}

	public void setCallbackModelId(Integer callbackModelId) {
		this.callbackModelId = callbackModelId;
	}

	public Integer getCallbackResId() {
		return this.callbackResId;
	}

	public void setCallbackResId(Integer callbackResId) {
		this.callbackResId = callbackResId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BigDecimal getFees() {
		return this.fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public String getHtml3ds() {
		return this.html3ds;
	}

	public void setHtml3ds(String html3ds) {
		this.html3ds = html3ds;
	}

	public Boolean getIsProcessed() {
		return this.isProcessed;
	}

	public void setIsProcessed(Boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getPartnerAddress() {
		return this.partnerAddress;
	}

	public void setPartnerAddress(String partnerAddress) {
		this.partnerAddress = partnerAddress;
	}

	public String getPartnerCity() {
		return this.partnerCity;
	}

	public void setPartnerCity(String partnerCity) {
		this.partnerCity = partnerCity;
	}

	public Integer getPartnerCountryId() {
		return this.partnerCountryId;
	}

	public void setPartnerCountryId(Integer partnerCountryId) {
		this.partnerCountryId = partnerCountryId;
	}

	public String getPartnerEmail() {
		return this.partnerEmail;
	}

	public void setPartnerEmail(String partnerEmail) {
		this.partnerEmail = partnerEmail;
	}

	public String getPartnerLang() {
		return this.partnerLang;
	}

	public void setPartnerLang(String partnerLang) {
		this.partnerLang = partnerLang;
	}

	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerPhone() {
		return this.partnerPhone;
	}

	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhone = partnerPhone;
	}

	public String getPartnerZip() {
		return this.partnerZip;
	}

	public void setPartnerZip(String partnerZip) {
		this.partnerZip = partnerZip;
	}

	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getPaymentTokenId() {
		return this.paymentTokenId;
	}

	public void setPaymentTokenId(Integer paymentTokenId) {
		this.paymentTokenId = paymentTokenId;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateMessage() {
		return this.stateMessage;
	}

	public void setStateMessage(String stateMessage) {
		this.stateMessage = stateMessage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

	public ResPartner getResPartner() {
		return this.resPartner;
	}

	public void setResPartner(ResPartner resPartner) {
		this.resPartner = resPartner;
	}

}