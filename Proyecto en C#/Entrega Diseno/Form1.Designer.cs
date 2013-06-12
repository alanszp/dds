namespace Entrega_Diseno
{
    partial class Form1
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
            this.cmbVenderentrada = new System.Windows.Forms.Button();
            this.cmbFila = new System.Windows.Forms.ComboBox();
            this.cmbNoche = new System.Windows.Forms.ComboBox();
            this.cmbCategoria = new System.Windows.Forms.ComboBox();
            this.cmbSector = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.lblPrecio = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.txtAsiento = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.cmbConfirmarVenta = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // cmbVenderentrada
            // 
            this.cmbVenderentrada.Location = new System.Drawing.Point(98, 231);
            this.cmbVenderentrada.Name = "cmbVenderentrada";
            this.cmbVenderentrada.Size = new System.Drawing.Size(81, 38);
            this.cmbVenderentrada.TabIndex = 0;
            this.cmbVenderentrada.Text = "Calcular";
            this.cmbVenderentrada.UseVisualStyleBackColor = true;
            this.cmbVenderentrada.Click += new System.EventHandler(this.cmbVenderentrada_Click);
            // 
            // cmbFila
            // 
            this.cmbFila.Enabled = false;
            this.cmbFila.FormattingEnabled = true;
            this.cmbFila.Items.AddRange(new object[] {
            "1-10",
            "11-20",
            "21-30"});
            this.cmbFila.Location = new System.Drawing.Point(120, 114);
            this.cmbFila.Name = "cmbFila";
            this.cmbFila.Size = new System.Drawing.Size(121, 21);
            this.cmbFila.TabIndex = 1;
            this.cmbFila.SelectedIndexChanged += new System.EventHandler(this.cmbFila_SelectedIndexChanged);
            // 
            // cmbNoche
            // 
            this.cmbNoche.FormattingEnabled = true;
            this.cmbNoche.Items.AddRange(new object[] {
            "25/07/2013",
            "26/07/2016\t",
            "27/07/2013"});
            this.cmbNoche.Location = new System.Drawing.Point(120, 63);
            this.cmbNoche.Name = "cmbNoche";
            this.cmbNoche.Size = new System.Drawing.Size(121, 21);
            this.cmbNoche.TabIndex = 2;
            this.cmbNoche.SelectedIndexChanged += new System.EventHandler(this.cmbNoche_SelectedIndexChanged);
            // 
            // cmbCategoria
            // 
            this.cmbCategoria.FormattingEnabled = true;
            this.cmbCategoria.Items.AddRange(new object[] {
            "Menor",
            "Mayor",
            "Jubilado"});
            this.cmbCategoria.Location = new System.Drawing.Point(120, 164);
            this.cmbCategoria.Name = "cmbCategoria";
            this.cmbCategoria.Size = new System.Drawing.Size(121, 21);
            this.cmbCategoria.TabIndex = 3;
            // 
            // cmbSector
            // 
            this.cmbSector.Enabled = false;
            this.cmbSector.FormattingEnabled = true;
            this.cmbSector.Items.AddRange(new object[] {
            "Sector:A",
            "Sector:C"});
            this.cmbSector.Location = new System.Drawing.Point(120, 87);
            this.cmbSector.Name = "cmbSector";
            this.cmbSector.Size = new System.Drawing.Size(121, 21);
            this.cmbSector.TabIndex = 4;
            this.cmbSector.SelectedIndexChanged += new System.EventHandler(this.cmbSector_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(31, 90);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Sector:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(32, 117);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(26, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Fila:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(31, 66);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(42, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Noche:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(30, 167);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(55, 13);
            this.label4.TabIndex = 8;
            this.label4.Text = "Categoria:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(30, 192);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(40, 13);
            this.label5.TabIndex = 9;
            this.label5.Text = "Precio:";
            // 
            // lblPrecio
            // 
            this.lblPrecio.AutoSize = true;
            this.lblPrecio.Location = new System.Drawing.Point(164, 192);
            this.lblPrecio.Name = "lblPrecio";
            this.lblPrecio.Size = new System.Drawing.Size(0, 13);
            this.lblPrecio.TabIndex = 10;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(31, 142);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(45, 13);
            this.label6.TabIndex = 11;
            this.label6.Text = "Asiento:";
            // 
            // txtAsiento
            // 
            this.txtAsiento.Location = new System.Drawing.Point(120, 139);
            this.txtAsiento.Name = "txtAsiento";
            this.txtAsiento.Size = new System.Drawing.Size(121, 20);
            this.txtAsiento.TabIndex = 12;
            this.txtAsiento.Visible = false;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(56, 24);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(143, 20);
            this.label7.TabIndex = 13;
            this.label7.Text = "VENTA ENTRADA";
            // 
            // cmbConfirmarVenta
            // 
            this.cmbConfirmarVenta.Location = new System.Drawing.Point(98, 275);
            this.cmbConfirmarVenta.Name = "cmbConfirmarVenta";
            this.cmbConfirmarVenta.Size = new System.Drawing.Size(81, 38);
            this.cmbConfirmarVenta.TabIndex = 14;
            this.cmbConfirmarVenta.Text = "Confirmar Venta";
            this.cmbConfirmarVenta.UseVisualStyleBackColor = true;
            this.cmbConfirmarVenta.Click += new System.EventHandler(this.cmbConfirmarVenta_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(269, 345);
            this.Controls.Add(this.cmbConfirmarVenta);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.txtAsiento);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.lblPrecio);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.cmbSector);
            this.Controls.Add(this.cmbCategoria);
            this.Controls.Add(this.cmbNoche);
            this.Controls.Add(this.cmbFila);
            this.Controls.Add(this.cmbVenderentrada);
            this.Name = "Form1";
            this.Text = "FESTIVAL DE ROCK";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button cmbVenderentrada;
        private System.Windows.Forms.ComboBox cmbFila;
        private System.Windows.Forms.ComboBox cmbNoche;
        private System.Windows.Forms.ComboBox cmbCategoria;
        private System.Windows.Forms.ComboBox cmbSector;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lblPrecio;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox txtAsiento;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button cmbConfirmarVenta;
    }
}

