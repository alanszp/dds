using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entrega_Diseno
{
    class RangoFilas
    {
        private int _Desde;
        public int Desde
        {
            get { return _Desde; }
            set { _Desde = value; }
        }

        private int _Hasta;
        public int Hasta
        {
            get { return _Hasta; }
            set { _Hasta = value; }
        }

        private int _Precio;
        public int Precio
        {
            get { return _Precio; }
            set { _Precio = value; }
        }

        private int _CantAsientos;
        public int CantAsientos
        {
            get { return _CantAsientos; }
            set { _CantAsientos = value; }
        }

        public RangoFilas(string nombre)
        {
            if (nombre == "1-10")
            {
                _Precio = 53;
            }
            else if(nombre == "11-20")
            {
                _Precio = 43;
            }
            else if (nombre == "21-30")
            {
                _Precio = 33;
            }
            else if (nombre == "31-40")
            {
                _Precio = 23;
            }
        }

        public bool tengoFilas(int fila)
        {
            if ((Desde >= fila) && (Hasta <= fila))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
