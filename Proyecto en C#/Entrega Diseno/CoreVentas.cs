using System;
using System.Collections.Generic;
using System.Text;
using System.Data.OleDb;


namespace Entrega_Diseno
{
    class CoreVentas
    {


        public bool venderEntrada(Entrada entrada)
        {
            /*
            OleDbConnection conexion = TP3.BaseDeDatos.ObtenerConexion();
            string sqlQuery = "select * from entradas WHERE fecha=" + entrada.Fecha + " and sector=" + entrada.Sector + " and asiento=" + entrada.Asiento;
            OleDbDataReader lector = TP3.BaseDeDatos.ObtenerDataReader(sqlQuery, "T", new List<OleDbParameter>());
            if (lector.FieldCount == 0)
            {
                addEntrada(entrada);
                return true;
            }
            else
            {
                return false;
            }*/
            if (entrada != null)
            {
                return true;
            } return false;
        }

        private void addEntrada(Entrada entrada)
        {
            OleDbConnection conexion = TP3.BaseDeDatos.ObtenerConexion();
            string sqlQuery = "INSERT INTO entradas (fecha, sector, asiento, categoria) VALUES (" + entrada.Fecha + ", " + entrada.Sector + ", " + entrada.Asiento + ", " + entrada.CategoriaPersona + ")";
            TP3.BaseDeDatos.EscribirEnBase(sqlQuery, "T", new List<OleDbParameter>());
        }

    }
}
