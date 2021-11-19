namespace DLLSalmenta
{
    partial class UserControl1
    {
        /// <summary> 
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de componentes

        /// <summary> 
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.bezeroakBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.erronkaUno_2DataSet = new DLLSalmenta.ErronkaUno_2DataSet();
            this.bezeroakTableAdapter = new DLLSalmenta.ErronkaUno_2DataSetTableAdapters.BezeroakTableAdapter();
            this.erronkaUno_2DataSet1 = new DLLSalmenta.ErronkaUno_2DataSet();
            this.lamonBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.lamonTableAdapter = new DLLSalmenta.ErronkaUno_2DataSetTableAdapters.LamonTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bezeroakBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.erronkaUno_2DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.erronkaUno_2DataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.lamonBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // chart1
            // 
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            this.chart1.Location = new System.Drawing.Point(96, 38);
            this.chart1.Name = "chart1";
            series1.ChartArea = "ChartArea1";
            series1.Name = "Series1";
            this.chart1.Series.Add(series1);
            this.chart1.Size = new System.Drawing.Size(450, 300);
            this.chart1.TabIndex = 0;
            this.chart1.Text = "chart1";
            // 
            // bezeroakBindingSource
            // 
            this.bezeroakBindingSource.DataMember = "Bezeroak";
            this.bezeroakBindingSource.DataSource = this.erronkaUno_2DataSet;
            // 
            // erronkaUno_2DataSet
            // 
            this.erronkaUno_2DataSet.DataSetName = "ErronkaUno_2DataSet";
            this.erronkaUno_2DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bezeroakTableAdapter
            // 
            this.bezeroakTableAdapter.ClearBeforeFill = true;
            // 
            // erronkaUno_2DataSet1
            // 
            this.erronkaUno_2DataSet1.DataSetName = "ErronkaUno_2DataSet";
            this.erronkaUno_2DataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // lamonBindingSource
            // 
            this.lamonBindingSource.DataMember = "Lamon";
            this.lamonBindingSource.DataSource = this.erronkaUno_2DataSet1;
            // 
            // lamonTableAdapter
            // 
            this.lamonTableAdapter.ClearBeforeFill = true;
            // 
            // UserControl1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.chart1);
            this.Name = "UserControl1";
            this.Size = new System.Drawing.Size(629, 385);
            this.Load += new System.EventHandler(this.UserControl1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bezeroakBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.erronkaUno_2DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.erronkaUno_2DataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.lamonBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.BindingSource bezeroakBindingSource;
        private ErronkaUno_2DataSet erronkaUno_2DataSet;
        private ErronkaUno_2DataSetTableAdapters.BezeroakTableAdapter bezeroakTableAdapter;
        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
        private ErronkaUno_2DataSet erronkaUno_2DataSet1;
        private System.Windows.Forms.BindingSource lamonBindingSource;
        private ErronkaUno_2DataSetTableAdapters.LamonTableAdapter lamonTableAdapter;
    }
}
