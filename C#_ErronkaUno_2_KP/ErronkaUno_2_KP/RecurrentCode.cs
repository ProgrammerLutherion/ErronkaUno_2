
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace ErronkaUno_2_KP
{
    class RecurrentCode
    {
        public static void showform1(Form f)
        {
            Form1 form1 = new Form1();
            f.Close();
            form1.Show();
        }

        public static void invis(Form f)
        {
            List<Label> lbls = f.Controls.OfType<Label>().ToList();
            List<Chart> chts = f.Controls.OfType<Chart>().ToList();
            List<UserControl> usrcs = f.Controls.OfType<UserControl>().ToList();
            foreach (var lbl in lbls) {
                if (lbl.Text != "Zenbat Erakutzi")
                {
                    lbl.Visible = false;
                }
            }

            foreach (var cht in chts)
            {
                cht.Visible = false;
            }

            foreach (var usrc in usrcs)
            {
                usrc.Visible = false;
            }
        }
    }
}
