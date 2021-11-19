using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ErronkaUno_2_KP
{
    public partial class Form3 : Form
    {
        ErronkaUno_2DataSet erronkaUno_2Data = new ErronkaUno_2DataSet();
        ErronkaUno_2DataSetTableAdapters.SalmentakHileroKantitateaTableAdapter salmentakHileroKantitateaTableAdapter = new ErronkaUno_2DataSetTableAdapters.SalmentakHileroKantitateaTableAdapter();
        ErronkaUno_2DataSetTableAdapters.SalmentakHileroDiruTableAdapter salmentakHileroDiruTableAdapter = new ErronkaUno_2DataSetTableAdapters.SalmentakHileroDiruTableAdapter();
        int num = 5;
        public Form3()
        {
            InitializeComponent();
        }
        private void Form3_Load(object sender, EventArgs e)
        {
            setCharts();
            label2.Visible = true;
            chart2.Visible = true;
        }

        private void setCharts()
        {
            this.salmentakHileroKantitateaTableAdapter.Fill(this.erronkaUno_2Data.SalmentakHileroKantitatea);
            chart1.DataSource = salmentakHileroKantitateaTableAdapter.GetDataBy().Select().Take(num);
            chart1.Series[0].YValueMembers = "Guztira";
            chart1.Series[0].XValueMember = "Hilabete";
            chart1.DataBind();

            this.salmentakHileroDiruTableAdapter.Fill(this.erronkaUno_2Data.SalmentakHileroDiru);
            chart2.DataSource = salmentakHileroDiruTableAdapter.GetDataBy().Select().Take(num);
            chart2.Series[0].YValueMembers = "Guztira";
            chart2.Series[0].XValueMember = "Hilabete";
            chart2.DataBind();

        }

            private void Button1_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label2.Visible = true;
            chart2.Visible = true;
        }
        private void Button3_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            chart1.Visible = true;
            label1.Visible = true;
        }
        private void Button4_Click(object sender, EventArgs e)
        {
            RecurrentCode.showform1(this);
        }
        private void TextBox1_TextChanged(object sender, EventArgs e)
        {
            try
            {
                num = Int32.Parse(textBox1.Text);
                setCharts();
            }
            catch
            {
                textBox1.Text = "";
            }
        }
    }
}
