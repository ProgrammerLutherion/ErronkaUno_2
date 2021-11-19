namespace ErronkaUno_2_KP
{
    partial class Form4
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.button4 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.userControl11 = new DLLSalmenta.UserControl1();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            this.SuspendLayout();
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(68, 386);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(105, 29);
            this.button4.TabIndex = 16;
            this.button4.Text = "Atzera";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.Button4_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(68, 265);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(105, 50);
            this.button3.TabIndex = 19;
            this.button3.Text = "Hornitzaile Erosketa Gehien";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.Button3_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(68, 144);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(105, 50);
            this.button1.TabIndex = 17;
            this.button1.Text = "Hornitzaile Diru Gehien";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.Button1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold);
            this.label1.Location = new System.Drawing.Point(374, 38);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(227, 24);
            this.label1.TabIndex = 20;
            this.label1.Text = "Hornitzaile Diru Gehien";
            this.label1.Visible = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold);
            this.label2.Location = new System.Drawing.Point(374, 38);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(270, 24);
            this.label2.TabIndex = 21;
            this.label2.Text = "Hornitzaile Erosketa Gehien";
            this.label2.Visible = false;
            // 
            // userControl11
            // 
            this.userControl11.Location = new System.Drawing.Point(180, 66);
            this.userControl11.Name = "userControl11";
            this.userControl11.Size = new System.Drawing.Size(546, 362);
            this.userControl11.TabIndex = 22;
            this.userControl11.Visible = false;
            // 
            // chart1
            // 
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            this.chart1.Location = new System.Drawing.Point(277, 104);
            this.chart1.Name = "chart1";
            series1.ChartArea = "ChartArea1";
            series1.Name = "Series1";
            this.chart1.Series.Add(series1);
            this.chart1.Size = new System.Drawing.Size(449, 301);
            this.chart1.TabIndex = 23;
            this.chart1.Text = "chart1";
            this.chart1.Visible = false;
            // 
            // Form4
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.chart1);
            this.Controls.Add(this.userControl11);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.button4);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Form4";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "EROSKETAK";
            this.Load += new System.EventHandler(this.Form4_Load);
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private DLLSalmenta.UserControl1 userControl11;
        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
    }
}