using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;

namespace Entrega_Diseno
{
    class Sector
    {
        private string _Nombre;
        public string Nombre
        {
            get
            {
                return _Nombre;
            }
            set
            {
                _Nombre = value;
            }
        }

        private int _Precio;
        public int Precio
        {
            get { return _Precio; }
            set { _Precio = value; }
        }

        private RangoFilas _RangoFilas;
        public RangoFilas RangoFilas
        {
            get { return _RangoFilas; }
            set { _RangoFilas = value; }
        }

        public Sector(string Nombre)
        {

            _Nombre = Nombre;
            if (_Nombre == "Sector:A")
            {
                _Precio = 320;
            }
            else
            {
                _Precio = 100;
            }
        }

        public float valorEntradaBase()
        {
            return (Precio + _RangoFilas.Precio);
        }
    }
}
