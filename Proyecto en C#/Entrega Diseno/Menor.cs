using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entrega_Diseno
{
    class Menor: CategoriaPersona
    {
        private float _PrecioDescuento;
        public float PrecioDescuento
        {
            get { return _PrecioDescuento; }
            set { _PrecioDescuento = 10; }
        }

        private double _PorcentajeDescuento;
        public double PorcentajeDescuento
        {
            get { return _PorcentajeDescuento; }
            set { _PorcentajeDescuento = 0.80 ; }
        }

        float CategoriaPersona.aplicarDescuento(float entradaBase)
        {
            if (entradaBase > 100)
            {
                return ( (float) (entradaBase * _PorcentajeDescuento));
            }
            else if ((entradaBase > 50) && (entradaBase <= 100))
            {
                return (entradaBase - _PrecioDescuento);
            }
            else
            {
                return entradaBase;
            }
        }

        double CategoriaPersona.PrecioDescuento
        {
            get
            {
                throw new NotImplementedException();
            }
            set
            {
                throw new NotImplementedException();
            }
        }
    }
}
