public class Fuhrpark {

		private int anzahlFuhrwerke;
		private int preisFuhrwerk;
		private int status;
		private int gesendet;
	
		public Fuhrpark(int anzahlFuhrwerke, int preisFuhrwerke) {
			this.anzahlFuhrwerke=anzahlFuhrwerke;
			this.preisFuhrwerk=preisFuhrwerke;
			
		}
		
		public void kaufen(int menge) {
			if (menge > 0) {
			this.anzahlFuhrwerke=this.anzahlFuhrwerke + menge; 
			}
		}
		
		public void verkaufen(int menge) {
			if (menge > 0) {
			this.anzahlFuhrwerke=this.anzahlFuhrwerke - menge;
			}
		}
		
		public int handelspreis(int menge) {
			return menge*this.preisFuhrwerk;
		}
		
		
		public int getAnzahl() {
			return anzahlFuhrwerke;
		}

		public void setAnzahl(int anzahl) {
			this.anzahlFuhrwerke = anzahl;
		}

		public int getPreis() {
			return preisFuhrwerk;
		}

		public void setPreis(int preis) {
			this.preisFuhrwerk = preis;
		}
		
		
}
