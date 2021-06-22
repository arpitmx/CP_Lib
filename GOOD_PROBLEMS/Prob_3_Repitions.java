
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class prob3 {
   /** 
   
   Question : Problem Description :-
   
     You are given a DNA sequence: a string consisting of 
    characters A, C, G, and T. Your task is to find the longest repetition 
    in the sequence. This is a maximum-length substring containing 
    only one type of character.
   
   **/
    
        
    // Repetitions (Problem 3 CSES) 
    // LINK > https://cses.fi/problemset/task/1069
    
    
    
    static Reader rb;

    public static void main(String[] args)
            throws IOException {

        rb = new Reader();
        System.out.println(Solution());



    }


//=====================- SOLUTION -===================>

    static int Solution() throws IOException {
       int maxCount= 1;

        String inp = rb.readLine();
        char c ;

        for (int i= 0 ;  i < inp.length();){
          c = inp.charAt(i);
          int count =1;

          for (int j = i+1;j< inp.length();j++){
                    if (c==inp.charAt(j)) ++count ;
                    else break;
          }

          if (count >= maxCount) maxCount = count;
          i += count;

        }

        return maxCount;
    }

    static int[] convStrngArrToInt(String[] arr ){
        int arr_lenght = arr.length;
        int[] int_arr = new int[arr_lenght];
        for(int i = 0 ; i < arr_lenght;i++){
            int_arr[i] = Integer.parseInt(arr[i]);
        }
        return int_arr;
    }

    static boolean isPresent(int[] a, int value) {
        boolean isPresent= false;
        for (int i : a) {
            if (i == value) {
                isPresent =true;
                break;

            }

        }
        return isPresent;
    }

    static boolean isEven(long n) {
        return (n ^ 1) == n + 1;
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}


//================================= Reader ===================================================>


