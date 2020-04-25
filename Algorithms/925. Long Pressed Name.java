class Solution {
    public boolean isLongPressedName(String name, String typed) {
        /*
            Two pointers
            String
        */
        int pointername = 0;
        int pointertype = 0;
        
        while (pointername < name.length() && pointertype < typed.length()) {
            if (name.charAt(pointername) == typed.charAt(pointertype)) {
                pointername++;
                pointertype++;
            } else {
                pointertype++;
            }
        }
        //System.out.println(pointername + " " + pointertype);
        if (pointername == name.length()) return true;
        else return false;
    }
}