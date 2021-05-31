import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IdentificadorDeSistemaOperativo {


    public static void main(String[] args) throws IOException {
        
        if (args.length < 1 || args.length > 1){
            System.err.println("**** El uso de la app es: java IdentificadorDeSistemaOperativo [ARGS]");
            System.err.println("**** los [ARGUMENTOS] son la ip de la maquina objetivo");
        }
        
        
        
        Process process = Runtime.getRuntime().exec("ping -c 1 "+ args[0]);
        InputStream input = new BufferedInputStream(process.getInputStream());
        InputStreamReader inputStream = new InputStreamReader(input);
        BufferedReader bufferReader = new BufferedReader(inputStream);


        String output = null;
        while((bufferReader.readLine())!=null){
            output += bufferReader.readLine();
        }

        String[] array = output.split(" ");
        Pattern pattern = Pattern.compile("^ttl.*");
        String stringTTL = null;

        for(String word: array){
            Matcher match = pattern.matcher(word);
            if (match.matches()) {
                stringTTL = word;
            }
        }
        stringTTL = stringTTL.replaceAll("\\D+", "");

        int ttl = Integer.parseInt(stringTTL);

        if (ttl >= 0 && ttl <= 64){
            System.out.println("La maquina objetivo es un linux");
        } else if (ttl >= 65 && ttl <= 128){
            System.out.println("La maquina objetivo es un windows");
        }

    }
}
