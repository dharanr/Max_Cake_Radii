<pre>Office Party Cake Distribution problem

There is an office party to celebrate the last quarter's performance with cake for everyone!
Many different circular cakes are ordered.

Given the radii of the circular cakes and the number of guests, determine the largest piece 
that can be cut from the cakes such that every guest gets a piece with the same area. 

It is not possible that a single piece has some part of one cake and some part of another cake. 
To be fair, every guest is served only one piece of cake.
NOTE: Use 3.14159265359 as the value of pi and return the answer rounded to 4 places after the decimal. 
      The answer is accepted if the absolute error is within 10-4 i.e (1e-4).
						
For example, there are 6 cakes with radii = [1, 1, 1, 2, 2, 3] and there need to be numberOfGuests = 6 equal size pieces.
Area of a cake with radius r is calculated as (pi * radius * radius).
For radii 1, 2 and 3, the areas are 3.14159265359, 12.5663706156, and 28.2743338851 units2.

It would be possible to serve everyone a piece that matches the area of the circle with radius 1, 
but that would not be the biggest piece possible that can be served to everyone.

The best way to cut the cakes is to cut the largest cake into 4 pieces (area = 28.743338851 / 4 = 7.068583471275) 
and a similar size piece from each of the cakes with radius 2.
So, the answer is 7.0686. 	

Determine the largest piece that can be cut given the above conditions.
							
Function Description
Write a function named largestPiece. 
The function must return the maximum possible area of each piece of cake rounded to 4 decimals and cast as a string.

largestPiece has the following parameters: 
	•	radii[radius[0],...radius[n-1]]: an array of integers where ith element denotes the radius of the ith cake.
	•	numberOfGuests: an integer, the number of guests

Constraints
	•	1 ≤ size of radii ≤ 105
	•	1 ≤ radiii ≤ 104 (where 0 ≤ i ≤ size of radii) 1 ≤ numberOfGuests ≤ 105
Input Format For Custom Testing
	•	The first line contains an integer, n, that denotes the number of elements in radii.
	•	Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer that describes radiii.
	•	The last line contains an integer, numberOfGuests, that denotes the number of guests at the party.
						
Sample Case 0				
Sample Input For Custom Testing
3
4
3
3
3
Sample Output
28.2743

Explanation					
There are 3 cakes of radius = [4, 3, 3]. Each can have a piece as large as the smallest cake, radius1 = radius2 = 3. 
The area of each slice can be pi * r * r = pi * 3 * 3 = 28.2743 units2.	

Sample Case 1
Sample Input For Custom Testing
1
5
5				
Sample Output
15.7079
</pre>
