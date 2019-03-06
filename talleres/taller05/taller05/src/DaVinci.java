

public class DaVinci {

    Graph g;
    int colored = 0;

    public DaVinci(Graph g){
        this.g = g;
    }

    public boolean Draw(int numColors){

        String[] colors = {"Blue","Green","Yellow","Red","Purple","Brown"};
        long i = 1;
        return startPainting(colors,g.nodeList.get(i),numColors);
    }

    private boolean startPainting(String[] colors,Points origin, int numColors){

        if(colored == g.nodeList.size()){
            return true;
        }else{

            origin.Visited();
            boolean isValid;
            int j = 0;

            //System.out.println("Entered");
            while(j<numColors){

                origin.setColor(colors[j]);
                //System.out.println("Entered2");
                isValid = checkNeighbors(origin);
                //System.out.println("Entered3");
                if(isValid){

                    //System.out.println("Entered");
                    break;

                } else if (j + 1 == numColors){

                    return false;

                }

                j++;
            }

            /*if(origin.arcs.size()==1 && false){

                return true;

            }
            */


            for (int i = 0; i < origin.arcs.size() && j+1!=numColors; i++) {

                Points neighbor = origin.arcs.get(i).getValue();

                if (!neighbor.isVisited()) {

                    //System.out.println("Entered Neighbor");
                    isValid = startPainting(colors,neighbor,numColors);
                    if (!isValid){
                        colored--;
                        j++;
                        origin.setColor(colors[j]);
                        while(j<numColors){
                            isValid = checkNeighbors(origin);
                            if(isValid){
                                colored++;
                                i=-1;
                                break;
                            }else if (j+1==numColors){
                                neighbor.Unvisited();
                                return false;
                            }else{
                                origin.setColor(colors[j]);
                            }
                        }

                    }else  if(isValid && !origin.isVisited()) {

                    }
                }
            }

            return true;
        }


    }

    private boolean checkNeighbors(Points origin){

        int i = 0;
        while(i<origin.arcs.size()){

            Points neighbor = origin.arcs.get(i).getValue();
            if(origin.getColor().equals(neighbor.getColor())){
                return false;
            }
            i++;
        }

        return true;

    }

}
