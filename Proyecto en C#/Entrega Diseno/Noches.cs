using System;
using System.Collections.Generic;
using System.Text;
using System.Data.OleDb;

namespace Entrega_Diseno
{
    class Noches
    {
        public static List<Noche> ObtenerTodos()
        {
            List<Noche> Lista = new List<Noche>();

            OleDbConnection conexion = TP3.BaseDeDatos.ObtenerConexion();

            OleDbDataReader lector = TP3.BaseDeDatos.ObtenerDataReader("SELECT * FROM noches", "T", new List<OleDbParameter>());

            if (lector.HasRows)
            {

                while (lector.Read())
                {

                    string Nombre = (string)lector["nombre"];
                    Noche unaNoche = new Noche();
                    unaNoche.Nombre = Nombre;
                    Lista.Add(unaNoche);
                }
            }
            return Lista;
        }
    }
}
