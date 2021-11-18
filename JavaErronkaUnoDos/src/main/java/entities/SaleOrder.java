package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the sale_order database table.
 * 
 */
@Entity
@Table(name="sale_order")
@NamedQuery(name="SaleOrder.findAll", query="SELECT s FROM SaleOrder s")
public class SaleOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="access_token")
	private String accessToken;

	@Column(name="amount_tax")
	private BigDecimal amountTax;

	@Column(name="amount_total")
	private BigDecimal amountTotal;

	@Column(name="amount_untaxed")
	private BigDecimal amountUntaxed;

	@Column(name="analytic_account_id")
	private Integer analyticAccountId;

	@Column(name="campaign_id")
	private Integer campaignId;

	@Column(name="cart_recovery_email_sent")
	private Boolean cartRecoveryEmailSent;

	@Column(name="client_order_ref")
	private String clientOrderRef;

	@Column(name="commitment_date")
	private Timestamp commitmentDate;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="currency_id")
	private Integer currencyId;

	@Column(name="currency_rate")
	private BigDecimal currencyRate;

	@Column(name="date_order")
	private Timestamp dateOrder;

	@Temporal(TemporalType.DATE)
	@Column(name="effective_date")
	private Date effectiveDate;

	@Column(name="fiscal_position_id")
	private Integer fiscalPositionId;

	private Integer incoterm;

	@Column(name="invoice_status")
	private String invoiceStatus;

	@Column(name="medium_id")
	private Integer mediumId;

	@Column(name="message_main_attachment_id")
	private Integer messageMainAttachmentId;

	private String name;

	private String note;

	@Column(name="opportunity_id")
	private Integer opportunityId;

	private String origin;

	@Column(name="partner_id")
	private Integer partnerId;

	@Column(name="partner_invoice_id")
	private Integer partnerInvoiceId;

	@Column(name="partner_shipping_id")
	private Integer partnerShippingId;

	@Column(name="payment_term_id")
	private Integer paymentTermId;

	@Column(name="picking_policy")
	private String pickingPolicy;

	@Column(name="pricelist_id")
	private Integer pricelistId;

	@Column(name="procurement_group_id")
	private Integer procurementGroupId;

	private String reference;

	@Column(name="require_payment")
	private Boolean requirePayment;

	@Column(name="require_signature")
	private Boolean requireSignature;

	@Column(name="sale_order_template_id")
	private Integer saleOrderTemplateId;

	@Column(name="show_update_pricelist")
	private Boolean showUpdatePricelist;

	@Column(name="signed_by")
	private String signedBy;

	@Column(name="signed_on")
	private Timestamp signedOn;

	@Column(name="source_id")
	private Integer sourceId;

	private String state;

	@Column(name="team_id")
	private Integer teamId;

	@Column(name="user_id")
	private Integer userId;

	@Temporal(TemporalType.DATE)
	@Column(name="validity_date")
	private Date validityDate;

	@Column(name="warehouse_id")
	private Integer warehouseId;

	@Column(name="warning_stock")
	private String warningStock;

	@Column(name="website_id")
	private Integer websiteId;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	public SaleOrder() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public BigDecimal getAmountTax() {
		return this.amountTax;
	}

	public void setAmountTax(BigDecimal amountTax) {
		this.amountTax = amountTax;
	}

	public BigDecimal getAmountTotal() {
		return this.amountTotal;
	}

	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}

	public BigDecimal getAmountUntaxed() {
		return this.amountUntaxed;
	}

	public void setAmountUntaxed(BigDecimal amountUntaxed) {
		this.amountUntaxed = amountUntaxed;
	}

	public Integer getAnalyticAccountId() {
		return this.analyticAccountId;
	}

	public void setAnalyticAccountId(Integer analyticAccountId) {
		this.analyticAccountId = analyticAccountId;
	}

	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Boolean getCartRecoveryEmailSent() {
		return this.cartRecoveryEmailSent;
	}

	public void setCartRecoveryEmailSent(Boolean cartRecoveryEmailSent) {
		this.cartRecoveryEmailSent = cartRecoveryEmailSent;
	}

	public String getClientOrderRef() {
		return this.clientOrderRef;
	}

	public void setClientOrderRef(String clientOrderRef) {
		this.clientOrderRef = clientOrderRef;
	}

	public Timestamp getCommitmentDate() {
		return this.commitmentDate;
	}

	public void setCommitmentDate(Timestamp commitmentDate) {
		this.commitmentDate = commitmentDate;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	public BigDecimal getCurrencyRate() {
		return this.currencyRate;
	}

	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}

	public Timestamp getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Integer getFiscalPositionId() {
		return this.fiscalPositionId;
	}

	public void setFiscalPositionId(Integer fiscalPositionId) {
		this.fiscalPositionId = fiscalPositionId;
	}

	public Integer getIncoterm() {
		return this.incoterm;
	}

	public void setIncoterm(Integer incoterm) {
		this.incoterm = incoterm;
	}

	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Integer getMediumId() {
		return this.mediumId;
	}

	public void setMediumId(Integer mediumId) {
		this.mediumId = mediumId;
	}

	public Integer getMessageMainAttachmentId() {
		return this.messageMainAttachmentId;
	}

	public void setMessageMainAttachmentId(Integer messageMainAttachmentId) {
		this.messageMainAttachmentId = messageMainAttachmentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getOpportunityId() {
		return this.opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Integer getPartnerInvoiceId() {
		return this.partnerInvoiceId;
	}

	public void setPartnerInvoiceId(Integer partnerInvoiceId) {
		this.partnerInvoiceId = partnerInvoiceId;
	}

	public Integer getPartnerShippingId() {
		return this.partnerShippingId;
	}

	public void setPartnerShippingId(Integer partnerShippingId) {
		this.partnerShippingId = partnerShippingId;
	}

	public Integer getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(Integer paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPickingPolicy() {
		return this.pickingPolicy;
	}

	public void setPickingPolicy(String pickingPolicy) {
		this.pickingPolicy = pickingPolicy;
	}

	public Integer getPricelistId() {
		return this.pricelistId;
	}

	public void setPricelistId(Integer pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Integer getProcurementGroupId() {
		return this.procurementGroupId;
	}

	public void setProcurementGroupId(Integer procurementGroupId) {
		this.procurementGroupId = procurementGroupId;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Boolean getRequirePayment() {
		return this.requirePayment;
	}

	public void setRequirePayment(Boolean requirePayment) {
		this.requirePayment = requirePayment;
	}

	public Boolean getRequireSignature() {
		return this.requireSignature;
	}

	public void setRequireSignature(Boolean requireSignature) {
		this.requireSignature = requireSignature;
	}

	public Integer getSaleOrderTemplateId() {
		return this.saleOrderTemplateId;
	}

	public void setSaleOrderTemplateId(Integer saleOrderTemplateId) {
		this.saleOrderTemplateId = saleOrderTemplateId;
	}

	public Boolean getShowUpdatePricelist() {
		return this.showUpdatePricelist;
	}

	public void setShowUpdatePricelist(Boolean showUpdatePricelist) {
		this.showUpdatePricelist = showUpdatePricelist;
	}

	public String getSignedBy() {
		return this.signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public Timestamp getSignedOn() {
		return this.signedOn;
	}

	public void setSignedOn(Timestamp signedOn) {
		this.signedOn = signedOn;
	}

	public Integer getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getValidityDate() {
		return this.validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	public Integer getWarehouseId() {
		return this.warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarningStock() {
		return this.warningStock;
	}

	public void setWarningStock(String warningStock) {
		this.warningStock = warningStock;
	}

	public Integer getWebsiteId() {
		return this.websiteId;
	}

	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
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

}