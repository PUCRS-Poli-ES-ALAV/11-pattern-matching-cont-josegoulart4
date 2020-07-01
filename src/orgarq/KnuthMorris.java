package orgarq;

class KnuthMorris {
    public int KMPSearch(String pat, String txt) {
        int iterations = 0;
        int instructions = 0;
        int M = pat.length();
        int N = txt.length();

        // cria lps[] que vai guardar o maior
        // valor prefixo sufixo para o padrão
        int lps[] = new int[M];
        int j = 0; // index for pat[]
        instructions+=4;
        // Calcula lps[]
        int[] ins = computeLPSArray(pat, M, lps, iterations, instructions);
        iterations += ins[0];
        instructions += ins[1];

        int i = 0; // index for txt[]
        while (i < N) {
            iterations++;
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
                instructions+=2;
            }
            if (j == M) {
                System.out.println("Iterações: " + iterations);
                System.out.println("Instruções: " + instructions);
                return i;
            }

            // mismatch após j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                instructions +=2;
                // Não faz match dos caracteres lps[0..lps[j-1]],
                // não é necesssário, eles combinarão
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return 0;
    }

    private int[] computeLPSArray(String pat, int M, int lps[], int iterations, int instructions) {
        // tamanho do maior prefixo sufixo anterior
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // loop calcula lps[i] for i = 1 to M-1
        while (i < M) {
            iterations++;
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                instructions+=5;
            } else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                    instructions++;
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                    instructions+=2;
                }
            }
        }
        return new int[] {iterations, instructions};
    }
}