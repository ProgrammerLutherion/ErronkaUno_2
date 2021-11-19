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
    public partial class Form5 : Form
    {
        ErronkaUno_2DataSet erronkaUno_2Data = new ErronkaUno_2DataSet();
        ErronkaUno_2DataSetTableAdapters.ProduktoDiruaTableAdapter produktoDiruaTableAdapter = new ErronkaUno_2DataSetTableAdapters.ProduktoDiruaTableAdapter();
        ErronkaUno_2DataSetTableAdapters.ProduktoKantitateaTableAdapter produktoKantitateaTableAdapter = new ErronkaUno_2DataSetTableAdapters.ProduktoKantitateaTableAdapter();
        int num = 5;
        public Form5()
        {
            InitializeComponent();
        }
        private void Form5_Load(object sender, EventArgs e)
        {
            setCharts();
            label1.Visible = true;
            chart2.Visible = true;
        }

        private void setCharts()
        {
            this.produktoDiruaTableAdapter.Fill(this.erronkaUno_2Data.ProduktoDirua);
            chart1.DataSource = produktoDiruaTableAdapter.GetDataBy().Select().Take(num);
            chart1.Series[0].YValueMembers = "Dirua";
            chart1.Series[0].XValueMember = "Izena";
            chart1.DataBind();

            this.produktoKantitateaTableAdapter.Fill(this.erronkaUno_2Data.ProduktoKantitatea);
            chart2.DataSource = produktoKantitateaTableAdapter.GetDataBy().Select().Take(num);
            chart2.Series[0].YValueMembers = "Kantitatea";
            chart2.Series[0].XValueMember = "Izena";
            chart2.DataBind();
        }

            private void Button3_Click(object sender, EventArgs e)
        {

            RecurrentCode.invis(this);
            label2.Visible = true;
            chart1.Visible = true;
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label1.Visible = true;
            chart2.Visible = true;
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
