// t(n) = 2T (n/2) + n

// Let's expand the recursion and see the pattern:
// T(n)=2T(n/2)+n
//         =2(2T(n/4)+ n/2)+n
//         =2^2T(n/2^2)+2n
//         =2^3T(n/2^3)+3n
//         ;
//         =2^k*T(n/2^k)+kn

// We Continue until n/2^k = 1. This implies k=log2n.

// Now, substitute k=log2n:

//         T(n)=2^log2n* T(1)+nlog2n
//             =nT(1)+nlog2n
//             =nT(1)+nlog2n

//             or O(nlogn)
