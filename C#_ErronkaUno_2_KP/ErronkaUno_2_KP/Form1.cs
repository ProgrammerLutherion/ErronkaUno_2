using System;
using System.Windows.Forms;

namespace ErronkaUno_2_KP
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void Button1_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            this.Hide();
            form2.Show();
        }
        private void Button4_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3();
            this.Hide();
            form3.Show();
        }
        private void Button5_Click(object sender, EventArgs e)
        {
            Form4 form4 = new Form4();
            this.Hide();
            form4.Show();
        }
        private void Button2_Click(object sender, EventArgs e)
        {
            Form5 form5 = new Form5();
            this.Hide();
            form5.Show();
        }
    }
}
