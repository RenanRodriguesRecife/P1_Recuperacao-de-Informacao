package classifi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;


public class Preprocess {
	private static final Pattern UNDESIRABLES = Pattern.compile("(?![._])\\p{Punct}");

	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}

	
	public static String StopWord(String html){
		Pattern p = Pattern.compile("\\b(x|r|a|abaixo|acaso|acima|afinal|afora|agora|ah|ai|ainda|alem|algo|alguem|algum|alguma|algumas|alguém|ali|alias|aliás|alta|alto|além|amanha|amanhã|ante|antes|ao|aos|apenas|apos|após|aquela|aquelas|aquele|aqueles|aquem|aqui|aquilo|aquém|as|assim|ate|atencao|atenção|atras|atrás|até|aí|baixa|baixas|baixo|baixos|bastante|bem|bilhao|bilhão|bom|ca|cada|caso|catorze|cedo|cem|centena|centesimo|centésimo|certo|cinco|cinquenta|cinqüenta|click|clique|com|comigo|como|conforme|conosco|consigo|consoante|contanto|contigo|contra|contudo|convosco|cuidado|cuja|cujas|cujas|cujo|cá|da|daquela|daquelas|daquele|daqueles|daquilo|das|de|debaixo|decimo|dela|delas|dele|deles|demais|dentro|depois|desde|dessa|dessas|desse|desses|desta|destas|deste|destes|determinado|deve|dez|dezena|dezenove|dezesseis|dezessete|dezoito|disso|do|dobro|dois|dos|doze|duas|duplo|durante|duzentas|duzentos|duzia|dúzia|e|e-mail|eis|ela|elas|ele|eles|em|em|email|embora|enfim|enquanto|entao|entre|entretanto|então|era|essa|essas|esse|esses|esta|estamos|estas|este|estes|está|estão|eu|exceto|exclusiva|exclusivo|exemplo|exemplos|faz|foi|fora|forte|fortes|fraca|fracas|fraco|fracos|frente|grande|ha|hoje|hum|há|inclusive|isso|isto|ja|jamais|já|la|lhe|lhes|logo|longe|mais|mal|maneira|maneiras|mas|mau|me|medida|meio|meios|melhor|menos|mesma|mesmas|mesmo|mesmos|metade|meu|meus|mil|milesimo|milesimos|milhao|milhar|milhoes|milhão|milhões|milésimo|milésimos|mim|minha|minhas|modo|modos|muitas|muito|muitos|na|nada|nao|nas|nem|nenhum|nenhuma|nesta|ninguem|ninguém|no|nono|nos|nossa|nossas|nosso|nossos|nove|novecentas|novecentos|noventa|numa|nunca|não|nós|o|oba|oh|oitavo|oitenta|oito|oitocentas|oitocentos|olha|onde|ontem|onze|opa|ora|os|ou|outra|outro|outrora|outros|para|pela|pelas|pelo|pelos|pequena|pequeno|perante|perto|pior|pode|pois|por|porem|porquanto|porque|portanto|porventura|porém|poucas|pouco|pra|primeira|primeiras|primeiro|primeiros|proporcao|proporcoes|proporcões|proporção|propria|proprias|proprio|proprios|própria|próprias|próprio|próprios|puxa|pôr|quais|quaisquer|qual|qualquer|quando|quanta|quantas|quanto|quantos|quao|quarenta|quarto|quase|quatorze|quatro|quatrocentas|quatrocentos|que|quem|quer|quica|quinhentas|quinhentos|quinta|quinto|quinze|quão|saber|salve|salvo|sao|se|segunda|segundo|seis|seiscentas|seiscentos|seja|sem|semelhante|sempre|senao|senão|sequer|ser|sera|será|serão|sessenta|sete|setecentas|setecentos|setenta|setimo|seu|seus|sexto|si|sim|so|sob|sobre|sobretudo|somente|sua|suas|são|sétimo|só|tal|talvez|tambem|também|tampouco|tanto|tao|tarde|te|tem|terca|terceira|terceiro|terco|terça|terço|teu|teus|ti|todavia|todos|tres|treze|trezentas|trezentos|trigesimo|trigésimo|trilhao|trilhão|trinta|triplice|triplo|três|tríplice|tu|tua|tuas|tudo|tão|ui|um|uma|umas|unica|unicas|unico|unicos|uns|varias|varios|vez|vezes|vigesimo|vigésimo|vinte|viva |voce|voces|você|vocês|vos|vossa|vossas|vosso|vossos|vái|várias|vários|vós|à|às|é|única|únicas|único|únicos|manha|manhã|noite|exemplo|Km|cm|Kg|g|m|comum|dia|mes|mês|ano|minutos|segundos.....)\\b\\s?");
		   Matcher m = p.matcher(html);
		    String s = m.replaceAll("");
		    return s;
	 }
	
	

	private static String removePontua(String x) {
	    return UNDESIRABLES.matcher(x).replaceAll("");
	}
	
	private static String removeNum(String x) {
	    return x.replaceAll("[0-9]","");
	}
	
    public static void main(String[] args) throws Exception {

    
    	ArrayList<String> lista = new ArrayList<String>();  
    	
    	lista.add("");
    	 lista.add("");
    		lista.add("");
    	    	lista.add("");
    	    	lista.add("");
    	    	lista.add("");
    	    	lista.add("");
    	    	lista.add("");
    	    	lista.add("");
    	    	lista.add("");
    	    	
    	    	
    	for(String s : lista) {  
    		
    	
    	URL url = new URL(s);
    	 InputStream is = (InputStream) url.getContent();
    	 BufferedReader br = new BufferedReader(new InputStreamReader(is));
    	 String line = null;
    	 StringBuffer sb = new StringBuffer();
    	 while((line = br.readLine()) != null){
    	   sb.append(line);
    	 }
    	 String htmlContent = sb.toString();
    	 //System.out.println(htmlContent);
    	 //System.out.println(html2text(htmlContent));
    	 System.out.println(removeNum(removePontua(StopWord(html2text(htmlContent).toLowerCase()))));
    	 System.out.println("");
    }
    }
}


/*
 * 
 lista.add("");
 lista.add("");
	lista.add("");
    	lista.add("");
    	lista.add("");
    	lista.add("");
    	lista.add("");
    	lista.add("");
    	lista.add("");
    	lista.add("");
    	*/
