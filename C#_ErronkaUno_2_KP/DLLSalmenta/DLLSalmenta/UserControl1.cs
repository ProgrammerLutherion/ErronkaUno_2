using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DLLSalmenta
{
    public partial class UserControl1 : UserControl
    {
        public UserControl1()
        {
            InitializeComponent();

        }

        private void UserControl1_Load(object sender, EventArgs e)
        {
            this.lamonTableAdapter.Fill(this.erronkaUno_2DataSet.Lamon);

            chart1.DataSource = this.lamonTableAdapter.GetDataBy().Select();

            chart1.Series[0].YValueMembers = "Kop_oso";
            chart1.Series[0].XValueMember = "Izena";
            chart1.DataBind();
        }
       
    }
}
