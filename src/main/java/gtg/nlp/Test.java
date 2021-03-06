package gtg.nlp;

import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        Annotation document = new Annotation("Barack Obama was born in Hawaii.  He is the president. Obama was elected in 2008.");
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,mention,coref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);
        System.out.println("---");
        System.out.println("coref chains");
        for (CorefChain cc : document.get(CorefCoreAnnotations.CorefChainAnnotation.class).values()) {
            System.out.println("\t" + cc);
            System.out.println("\t" +cc.getMentionsInTextualOrder().get(0).toString()+ cc.getMentionsInTextualOrder().get(0).mentionSpan + cc.getMentionsInTextualOrder().get(0).sentNum);
            System.out.println(cc.getMentionsInTextualOrder().get(0).toString() + '\n' +
            cc.getMentionsInTextualOrder().get(1).sentNum + '\n' +
            cc.getMentionsInTextualOrder().get(2).mentionSpan);

        }
    }
}
