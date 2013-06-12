using System;
using System.Collections.Generic;
using System.Text;

namespace Entrega_Diseno
{
    class Noche
    {
        private DateTime _Fecha;
        public DateTime Fecha
        {
            get { return _Fecha; }
            set { _Fecha = value; }
        }
        private string _Nombre;
        public string Nombre
        {
            get { return _Nombre; }
            set { _Nombre = value; }
        }
        private List<Banda> _Bandas;
        public List<Banda> Bandas
        {
            get { return _Bandas; }
            set { _Bandas = value; }
        }

        public float valorExtraPorNoche() {
            float valorExtraPorNoche = 0;
            return 20;
           /*HARGODEO PORQUE NO FUNCA LO DE ABAJO! foreach (Banda banda in Bandas){
                valorExtraPorNoche += banda.Categoria.PrecioExtra;
            }
            return valorExtraPorNoche;
            */
        }
        public Noche()
        {
            //harcodeo
            CategoriaBanda categoria1 = new CategoriaBanda();
            categoria1.PrecioExtra= 10;
            categoria1.Tipo = 1;
            CategoriaBanda categoria2 = new CategoriaBanda();
            categoria2.PrecioExtra= 20;
            categoria2.Tipo = 2;
            
            Banda banda1= new Banda();
            Banda banda2= new Banda();
            banda1.Categoria= categoria1;
            banda1.Nombre = "Queen";
            banda2.Categoria= categoria2;
            banda2.Nombre = "Miranda";
            //NO FUNCA
         //   _Bandas.Add(banda1);
         //   _Bandas.Add(banda2);
            }
        }
    }
