namespace ErronkaUno_2_KP
{
    partial class Form3
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
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea2 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series2 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.button4 = new System.Windows.Forms.Button();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.chart2 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.button3 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.chart2)).BeginInit();
            this.SuspendLayout();
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(90, 370);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(105, 29);
            this.button4.TabIndex = 16;
            this.button4.Text = "Atzera";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.Button4_Click);
            // 
            // chart1
            // 
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            this.chart1.Location = new System.Drawing.Point(340, 71);
            this.chart1.Name = "chart1";
            series1.BorderWidth = 4;
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series1.Name = "Series1";
            this.chart1.Series.Add(series1);
            this.chart1.Size = new System.Drawing.Size(349, 328);
            this.chart1.TabIndex = 17;
            this.chart1.Text = "chart1";
            this.chart1.Visible = false;
            // 
            // chart2
            // 
            chartArea2.Name = "ChartArea1";
            this.chart2.ChartAreas.Add(chartArea2);
            this.chart2.Location = new System.Drawing.Point(340, 71);
            this.chart2.Name = "chart2";
            series2.ChartArea = "ChartArea1";
            series2.Name = "Series1";
            this.chart2.Series.Add(series2);
            this.chart2.Size = new System.Drawing.Size(349, 328);
            this.chart2.TabIndex = 18;
            this.chart2.Text = "chart2";
            this.chart2.Visible = false;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(90, 239);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(105, 50);
            this.button3.TabIndex = 20;
            this.button3.Text = "Hilero Erosketa Kantitatea";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.Button3_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(90, 128);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(105, 50);
            this.button1.TabIndex = 19;
            this.button1.Text = "Hilero Erosketa Dirua";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.Button1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold);
            this.label1.Location = new System.Drawing.Point(389, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(249, 24);
            this.label1.TabIndex = 21;
            this.label1.Text = "Hilero Erosketa Kantitatea";
            this.label1.Visible = false;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold);
            this.label2.Location = new System.Drawing.Point(414, 22);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(208, 24);
            this.label2.TabIndex = 22;
            this.label2.Text = "Hilero Erosketa Dirua";
            this.label2.Visible = false;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12.25F);
            this.label4.Location = new System.Drawing.Point(543, 412);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(125, 20);
            this.label4.TabIndex = 24;
            this.label4.Text = "Zenbat Erakutzi";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(674, 412);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(15, 20);
            this.textBox1.TabIndex = 23;
            this.textBox1.Text = "5";
            this.textBox1.TextChanged += new System.EventHandler(this.TextBox1_TextChanged);
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.chart2);
            this.Controls.Add(this.chart1);
            this.Controls.Add(this.button4);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Form3";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SALMENTAK";
            this.Load += new System.EventHandler(this.Form3_Load);
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.chart2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
        private System.Windows.Forms.DataVisualization.Charting.Chart chart2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBox1;
    }
}