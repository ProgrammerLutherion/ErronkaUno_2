package model.Postgre;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the account_move database table.
 * 
 */
@Entity
@Table(name="account_move")
@NamedQuery(name="AccountMove.findAll", query="SELECT a FROM AccountMove a")
public class AccountMove implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="access_token")
	private String accessToken;

	@Column(name="amount_residual")
	private BigDecimal amountResidual;

	@Column(name="amount_residual_signed")
	private BigDecimal amountResidualSigned;

	@Column(name="amount_tax")
	private BigDecimal amountTax;

	@Column(name="amount_tax_signed")
	private BigDecimal amountTaxSigned;

	@Column(name="amount_total")
	private BigDecimal amountTotal;

	@Column(name="amount_total_signed")
	private BigDecimal amountTotalSigned;

	@Column(name="amount_untaxed")
	private BigDecimal amountUntaxed;

	@Column(name="amount_untaxed_signed")
	private BigDecimal amountUntaxedSigned;

	@Column(name="auto_post")
	private Boolean autoPost;

	@Column(name="campaign_id")
	private Integer campaignId;

	@Column(name="commercial_partner_id")
	private Integer commercialPartnerId;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="currency_id")
	private Integer currencyId;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="edi_state")
	private String ediState;

	@Column(name="fiscal_position_id")
	private Integer fiscalPositionId;

	@Column(name="inalterable_hash")
	private String inalterableHash;

	@Column(name="invoice_cash_rounding_id")
	private Integer invoiceCashRoundingId;

	@Temporal(TemporalType.DATE)
	@Column(name="invoice_date")
	private Date invoiceDate;

	@Temporal(TemporalType.DATE)
	@Column(name="invoice_date_due")
	private Date invoiceDateDue;

	@Column(name="invoice_incoterm_id")
	private Integer invoiceIncotermId;

	@Column(name="invoice_origin")
	private String invoiceOrigin;

	@Column(name="invoice_partner_display_name")
	private String invoicePartnerDisplayName;

	@Column(name="invoice_payment_term_id")
	private Integer invoicePaymentTermId;

	@Column(name="invoice_source_email")
	private String invoiceSourceEmail;

	@Column(name="invoice_user_id")
	private Integer invoiceUserId;

	@Column(name="is_move_sent")
	private Boolean isMoveSent;

	@Column(name="journal_id")
	private Integer journalId;

	@Column(name="medium_id")
	private Integer mediumId;

	@Column(name="message_main_attachment_id")
	private Integer messageMainAttachmentId;

	@Column(name="move_type")
	private String moveType;

	private String name;

	private String narration;

	@Column(name="partner_bank_id")
	private Integer partnerBankId;

	@Column(name="partner_id")
	private Integer partnerId;

	@Column(name="partner_shipping_id")
	private Integer partnerShippingId;

	@Column(name="payment_id")
	private Integer paymentId;

	@Column(name="payment_reference")
	private String paymentReference;

	@Column(name="payment_state")
	private String paymentState;

	@Column(name="posted_before")
	private Boolean postedBefore;

	@Column(name="qr_code_method")
	private String qrCodeMethod;

	private String ref;

	@Column(name="secure_sequence_number")
	private Integer secureSequenceNumber;

	@Column(name="sequence_number")
	private Integer sequenceNumber;

	@Column(name="sequence_prefix")
	private String sequencePrefix;

	@Column(name="source_id")
	private Integer sourceId;

	private String state;

	@Column(name="statement_line_id")
	private Integer statementLineId;

	@Column(name="stock_move_id")
	private Integer stockMoveId;

	@Column(name="tax_cash_basis_rec_id")
	private Integer taxCashBasisRecId;

	@Column(name="team_id")
	private Integer teamId;

	@Column(name="to_check")
	private Boolean toCheck;

	@Column(name="website_id")
	private Integer websiteId;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to AccountMove
	@ManyToOne
	@JoinColumn(name="reversed_entry_id")
	private AccountMove accountMove1;

	//bi-directional many-to-one association to AccountMove
	@OneToMany(mappedBy="accountMove1")
	private List<AccountMove> accountMoves1;

	//bi-directional many-to-one association to AccountMove
	@ManyToOne
	@JoinColumn(name="tax_cash_basis_move_id")
	private AccountMove accountMove2;

	//bi-directional many-to-one association to AccountMove
	@OneToMany(mappedBy="accountMove2")
	private List<AccountMove> accountMoves2;

	public AccountMove() {
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

	public BigDecimal getAmountResidual() {
		return this.amountResidual;
	}

	public void setAmountResidual(BigDecimal amountResidual) {
		this.amountResidual = amountResidual;
	}

	public BigDecimal getAmountResidualSigned() {
		return this.amountResidualSigned;
	}

	public void setAmountResidualSigned(BigDecimal amountResidualSigned) {
		this.amountResidualSigned = amountResidualSigned;
	}

	public BigDecimal getAmountTax() {
		return this.amountTax;
	}

	public void setAmountTax(BigDecimal amountTax) {
		this.amountTax = amountTax;
	}

	public BigDecimal getAmountTaxSigned() {
		return this.amountTaxSigned;
	}

	public void setAmountTaxSigned(BigDecimal amountTaxSigned) {
		this.amountTaxSigned = amountTaxSigned;
	}

	public BigDecimal getAmountTotal() {
		return this.amountTotal;
	}

	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}

	public BigDecimal getAmountTotalSigned() {
		return this.amountTotalSigned;
	}

	public void setAmountTotalSigned(BigDecimal amountTotalSigned) {
		this.amountTotalSigned = amountTotalSigned;
	}

	public BigDecimal getAmountUntaxed() {
		return this.amountUntaxed;
	}

	public void setAmountUntaxed(BigDecimal amountUntaxed) {
		this.amountUntaxed = amountUntaxed;
	}

	public BigDecimal getAmountUntaxedSigned() {
		return this.amountUntaxedSigned;
	}

	public void setAmountUntaxedSigned(BigDecimal amountUntaxedSigned) {
		this.amountUntaxedSigned = amountUntaxedSigned;
	}

	public Boolean getAutoPost() {
		return this.autoPost;
	}

	public void setAutoPost(Boolean autoPost) {
		this.autoPost = autoPost;
	}

	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Integer getCommercialPartnerId() {
		return this.commercialPartnerId;
	}

	public void setCommercialPartnerId(Integer commercialPartnerId) {
		this.commercialPartnerId = commercialPartnerId;
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEdiState() {
		return this.ediState;
	}

	public void setEdiState(String ediState) {
		this.ediState = ediState;
	}

	public Integer getFiscalPositionId() {
		return this.fiscalPositionId;
	}

	public void setFiscalPositionId(Integer fiscalPositionId) {
		this.fiscalPositionId = fiscalPositionId;
	}

	public String getInalterableHash() {
		return this.inalterableHash;
	}

	public void setInalterableHash(String inalterableHash) {
		this.inalterableHash = inalterableHash;
	}

	public Integer getInvoiceCashRoundingId() {
		return this.invoiceCashRoundingId;
	}

	public void setInvoiceCashRoundingId(Integer invoiceCashRoundingId) {
		this.invoiceCashRoundingId = invoiceCashRoundingId;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getInvoiceDateDue() {
		return this.invoiceDateDue;
	}

	public void setInvoiceDateDue(Date invoiceDateDue) {
		this.invoiceDateDue = invoiceDateDue;
	}

	public Integer getInvoiceIncotermId() {
		return this.invoiceIncotermId;
	}

	public void setInvoiceIncotermId(Integer invoiceIncotermId) {
		this.invoiceIncotermId = invoiceIncotermId;
	}

	public String getInvoiceOrigin() {
		return this.invoiceOrigin;
	}

	public void setInvoiceOrigin(String invoiceOrigin) {
		this.invoiceOrigin = invoiceOrigin;
	}

	public String getInvoicePartnerDisplayName() {
		return this.invoicePartnerDisplayName;
	}

	public void setInvoicePartnerDisplayName(String invoicePartnerDisplayName) {
		this.invoicePartnerDisplayName = invoicePartnerDisplayName;
	}

	public Integer getInvoicePaymentTermId() {
		return this.invoicePaymentTermId;
	}

	public void setInvoicePaymentTermId(Integer invoicePaymentTermId) {
		this.invoicePaymentTermId = invoicePaymentTermId;
	}

	public String getInvoiceSourceEmail() {
		return this.invoiceSourceEmail;
	}

	public void setInvoiceSourceEmail(String invoiceSourceEmail) {
		this.invoiceSourceEmail = invoiceSourceEmail;
	}

	public Integer getInvoiceUserId() {
		return this.invoiceUserId;
	}

	public void setInvoiceUserId(Integer invoiceUserId) {
		this.invoiceUserId = invoiceUserId;
	}

	public Boolean getIsMoveSent() {
		return this.isMoveSent;
	}

	public void setIsMoveSent(Boolean isMoveSent) {
		this.isMoveSent = isMoveSent;
	}

	public Integer getJournalId() {
		return this.journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
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

	public String getMoveType() {
		return this.moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNarration() {
		return this.narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Integer getPartnerBankId() {
		return this.partnerBankId;
	}

	public void setPartnerBankId(Integer partnerBankId) {
		this.partnerBankId = partnerBankId;
	}

	public Integer getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Integer getPartnerShippingId() {
		return this.partnerShippingId;
	}

	public void setPartnerShippingId(Integer partnerShippingId) {
		this.partnerShippingId = partnerShippingId;
	}

	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentReference() {
		return this.paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getPaymentState() {
		return this.paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public Boolean getPostedBefore() {
		return this.postedBefore;
	}

	public void setPostedBefore(Boolean postedBefore) {
		this.postedBefore = postedBefore;
	}

	public String getQrCodeMethod() {
		return this.qrCodeMethod;
	}

	public void setQrCodeMethod(String qrCodeMethod) {
		this.qrCodeMethod = qrCodeMethod;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Integer getSecureSequenceNumber() {
		return this.secureSequenceNumber;
	}

	public void setSecureSequenceNumber(Integer secureSequenceNumber) {
		this.secureSequenceNumber = secureSequenceNumber;
	}

	public Integer getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSequencePrefix() {
		return this.sequencePrefix;
	}

	public void setSequencePrefix(String sequencePrefix) {
		this.sequencePrefix = sequencePrefix;
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

	public Integer getStatementLineId() {
		return this.statementLineId;
	}

	public void setStatementLineId(Integer statementLineId) {
		this.statementLineId = statementLineId;
	}

	public Integer getStockMoveId() {
		return this.stockMoveId;
	}

	public void setStockMoveId(Integer stockMoveId) {
		this.stockMoveId = stockMoveId;
	}

	public Integer getTaxCashBasisRecId() {
		return this.taxCashBasisRecId;
	}

	public void setTaxCashBasisRecId(Integer taxCashBasisRecId) {
		this.taxCashBasisRecId = taxCashBasisRecId;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Boolean getToCheck() {
		return this.toCheck;
	}

	public void setToCheck(Boolean toCheck) {
		this.toCheck = toCheck;
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

	public AccountMove getAccountMove1() {
		return this.accountMove1;
	}

	public void setAccountMove1(AccountMove accountMove1) {
		this.accountMove1 = accountMove1;
	}

	public List<AccountMove> getAccountMoves1() {
		return this.accountMoves1;
	}

	public void setAccountMoves1(List<AccountMove> accountMoves1) {
		this.accountMoves1 = accountMoves1;
	}

	public AccountMove addAccountMoves1(AccountMove accountMoves1) {
		getAccountMoves1().add(accountMoves1);
		accountMoves1.setAccountMove1(this);

		return accountMoves1;
	}

	public AccountMove removeAccountMoves1(AccountMove accountMoves1) {
		getAccountMoves1().remove(accountMoves1);
		accountMoves1.setAccountMove1(null);

		return accountMoves1;
	}

	public AccountMove getAccountMove2() {
		return this.accountMove2;
	}

	public void setAccountMove2(AccountMove accountMove2) {
		this.accountMove2 = accountMove2;
	}

	public List<AccountMove> getAccountMoves2() {
		return this.accountMoves2;
	}

	public void setAccountMoves2(List<AccountMove> accountMoves2) {
		this.accountMoves2 = accountMoves2;
	}

	public AccountMove addAccountMoves2(AccountMove accountMoves2) {
		getAccountMoves2().add(accountMoves2);
		accountMoves2.setAccountMove2(this);

		return accountMoves2;
	}

	public AccountMove removeAccountMoves2(AccountMove accountMoves2) {
		getAccountMoves2().remove(accountMoves2);
		accountMoves2.setAccountMove2(null);

		return accountMoves2;
	}

}