using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entrega_Diseno
{
    class Jubilado: CategoriaPersona
    {
        private double _PrecioDescuento;
        public double PrecioDescuento
        {
            get { return _PrecioDescuento; }
            set { _PrecioDescuento = 0.85 ; }
        }

        float CategoriaPersona.aplicarDescuento(float entradaBase)
        {
            return ( (float)(entradaBase * _PrecioDescuento));
        }
    }
}
