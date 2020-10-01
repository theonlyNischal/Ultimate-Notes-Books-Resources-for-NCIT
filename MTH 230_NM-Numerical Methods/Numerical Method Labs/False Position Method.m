%{
    Title: Roots using False Position Method
    Author: Nischal Lal Shrestha

%}

close all;
clear variables;
clc;

% Define Function
f = input('Enter the function: ', 's');
f = inline(f);
E = 0.00005;


% Root interval [a,b]

a = input('Enter the start root interval: ');
b = input('Enter the end root interval: ');

% Functional Value of root interval
fa = f(a);
fb = f(b);


% Select those root interval who have difference in sign
while(fa*fb > 0)
    % This loop run until a difference in sign is encountered
    a = input('Enter the start root interval: ');
    b = input('Enter the end root interval: ');
  
    % Functional Value of root interval
    fa = f(a);
    fb = f(b);
end




result = [a,fa,b,fb];
  disp('a       f(a)       b         f(b)     x     f(x)');
while((abs(b-a)>E))
  x = a - ((b-a)/(f(b)-f(a))) * f(a);
  fx = f(x);;

  result = [a,f(a),b,f(b),x,f(x)];
  disp(result);
  
  if(f(x)==0)
  result = strcat('The root lies at x = ',num2str(x));
  disp(result); 
  end
 
 if(f(a)*f(x)<0)
  b=x;
 else
  a=x;
 end

end

if (f(x) ~= 0)

disp('-----------------------------');

result = strcat('The root lies at x = ', num2str(x));
disp(result);
end

