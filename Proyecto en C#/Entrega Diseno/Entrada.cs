using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Entrega_Diseno
{
    class Entrada
    {
        private DateTime _Fecha;
        public DateTime Fecha
        {
            get { return _Fecha; }
            set { _Fecha = value; }
        }
        private Sector _Sector;
        public Sector Sector
        {
            get { return _Sector; }
            set { _Sector = value; }
        }
        private Noche _Noche;
        public Noche Noche
        {
            get { return _Noche; }
            set { _Noche = value; }
        }

        private CategoriaPersona _CategoriaPersona;
        public CategoriaPersona CategoriaPersona
        {
            get { return _CategoriaPersona; }
            set { _CategoriaPersona = value; }
        }

        private int _Asiento;
        public int Asiento
        {
            get { return _Asiento; }
            set { _Asiento = value; }
        }

        public float precioEntrada()
        {
            return (_Sector.valorEntradaBase() + _Noche.valorExtraPorNoche() + _CategoriaPersona.aplicarDescuento(_Sector.valorEntradaBase()) ); //falta sumarle el precio de la noche
        }

        public Entrada( Sector unSector, Noche unaNoche, CategoriaPersona categoria, int asiento)
        {
            _Asiento = asiento;
            _CategoriaPersona = categoria;
            _Fecha = DateTime.Now;
            _Noche = unaNoche;
            _Sector = unSector;
        }

    }
}
