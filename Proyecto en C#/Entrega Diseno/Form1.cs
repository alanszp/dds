using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Entrega_Diseno
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void cmbVenderentrada_Click(object sender, EventArgs e)
        {

            int asiento = Int32.Parse(txtAsiento.Text);
            Sector unSector = new Sector(cmbSector.Text);
            Noche unaNoche = new Noche(); 
            RangoFilas fila = new RangoFilas(cmbFila.Text.ToString());
            unSector.RangoFilas = fila;
            string cat = cmbCategoria.Text;
            CategoriaPersona categoria;
            switch (cat){
                case "Jubilado":
                    categoria = new Jubilado();
                    break;
                case "Menor":
                    categoria = new Menor();
                    break;
                default:case "Mayor":
                    categoria = new Mayor();
                    break;
            }
            Entrada unaEntrada = new Entrada(unSector, unaNoche, categoria, asiento);

            lblPrecio.Text = unaEntrada.precioEntrada().ToString();
        }

        private void cmbSector_SelectedIndexChanged(object sender, EventArgs e)
        {
            cmbFila.Enabled = true;
        }

        private void cmbNoche_SelectedIndexChanged(object sender, EventArgs e)
        {
            cmbSector.Enabled = true;
        }

        private void cmbFila_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtAsiento.Visible = true;
        }

        private void cmbConfirmarVenta_Click(object sender, EventArgs e)
        {
            CoreVentas coreVentas = new CoreVentas();

            int asiento = Int32.Parse(txtAsiento.Text);
            Sector unSector = new Sector(cmbSector.Text);
            Noche unaNoche = new Noche(); //hacer el constructor
            RangoFilas fila = new RangoFilas(cmbFila.Text.ToString());
            unSector.RangoFilas = fila;
            CategoriaPersona categoria = new Jubilado();
            Entrada unaEntrada = new Entrada(unSector, unaNoche, categoria, asiento);

            lblPrecio.Text = unaEntrada.precioEntrada().ToString();

            try
            {
                bool venta = coreVentas.venderEntrada(unaEntrada);
                if (venta)
                {
                    MessageBox.Show("La entrada ha sido vendida correctamente", "Enhorabuena!", MessageBoxButtons.OK);
                }
                else
                {
                    MessageBox.Show("La entrada ya ha sido vendida. ERROR CODE:1", "Error!", MessageBoxButtons.OK);
                }
            }
            catch
            {
                MessageBox.Show("Error durante la venta de entrada.", "Error!", MessageBoxButtons.OK);
            }
        }
    }
}
