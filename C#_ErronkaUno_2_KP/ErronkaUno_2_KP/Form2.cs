using System;
using System.Linq;
using System.Windows.Forms;

namespace ErronkaUno_2_KP
{
    public partial class Form2 : Form
    {

        ErronkaUno_2DataSet erronkaUno_2Data = new ErronkaUno_2DataSet();
        ErronkaUno_2DataSetTableAdapters.BezeroDineroTableAdapter bezeroDineroTableAdapter = new ErronkaUno_2DataSetTableAdapters.BezeroDineroTableAdapter();
        ErronkaUno_2DataSetTableAdapters.BezeroCantidadTableAdapter bezeroCantidadTableAdapter = new ErronkaUno_2DataSetTableAdapters.BezeroCantidadTableAdapter();
        ErronkaUno_2DataSetTableAdapters.BezeroRelacionTableAdapter bezeroRelacionTableAdapter = new ErronkaUno_2DataSetTableAdapters.BezeroRelacionTableAdapter();
        int num = 5;
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            setCharts();
            label1.Visible = true;
            chart2.Visible = true;
        }

        private void setCharts()
        {
            this.bezeroDineroTableAdapter.Fill(this.erronkaUno_2Data.BezeroDinero);
            chart1.DataSource = bezeroDineroTableAdapter.GetDataBy().Select().Take(num);
            chart1.Series[0].YValueMembers = "Guztira";
            chart1.Series[0].XValueMember = "Izena";
            chart1.DataBind();

            this.bezeroCantidadTableAdapter.Fill(this.erronkaUno_2Data.BezeroCantidad);
            chart2.DataSource = bezeroCantidadTableAdapter.GetDataBy().Select().Take(num);
            chart2.Series[0].YValueMembers = "Kantitatea";
            chart2.Series[0].XValueMember = "Izena";
            chart2.DataBind();

            this.bezeroRelacionTableAdapter.Fill(this.erronkaUno_2Data.BezeroRelacion);
            chart3.DataSource = bezeroRelacionTableAdapter.GetDataBy().Select().Take(num);
            chart3.Series[0].YValueMembers = "Relation";
            chart3.Series[0].XValueMember = "Izena";
            chart3.DataBind();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label1.Visible = true;
            chart2.Visible = true;
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label3.Visible = true;
            chart1.Visible = true;
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            RecurrentCode.invis(this);
            label2.Visible = true;
            chart3.Visible = true;
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
