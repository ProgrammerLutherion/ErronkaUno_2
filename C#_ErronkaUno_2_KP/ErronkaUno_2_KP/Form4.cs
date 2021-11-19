using System;
using System.Linq;
using System.Windows.Forms;

namespace ErronkaUno_2_KP
{
    public partial class Form4 : Form
    {
        ErronkaUno_2DataSet erronkaUno_2Data = new ErronkaUno_2DataSet();
        ErronkaUno_2DataSetTableAdapters.ErosketaKantitateaTableAdapter erosketaKantitateaTableAdapter = new ErronkaUno_2DataSetTableAdapters.ErosketaKantitateaTableAdapter();
        public Form4()
        {
            InitializeComponent();
        }
        private void Form4_Load(object sender, EventArgs e)
        {
            this.erosketaKantitateaTableAdapter.Fill(this.erronkaUno_2Data.ErosketaKantitatea);
            chart1.DataSource = erosketaKantitateaTableAdapter.GetDataBy().Select().Take(5);
            chart1.Series[0].YValueMembers = "Kantitatea";
            chart1.Series[0].XValueMember = "Izena";
            chart1.DataBind();

            label1.Visible = true;
            userControl11.Visible = true;
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label1.Visible = true;
            userControl11.Visible = true;
        }
        private void Button3_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label2.Visible = true;
            chart1.Visible = true;
        }
        private void Button4_Click(object sender, EventArgs e)
        {
            RecurrentCode.showform1(this);
        }
    }
}
