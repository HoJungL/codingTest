#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, a[1003][1003], lst[1003];
vector<array<int, 3>> v;

bool cmp(vector<int> a, vector<int> b) {
    if(a[0]!=b[0]) return a[0] < b[0];
    if( a[1]!=b[1]){
        return a[1] < a[2];
    }
    return a[2] < b[2];
	
}

int find(int x) {
	if (lst[x] != x)
        lst[x] = find(lst[x]);
 
    return lst[x];
}

void merge(int a, int b) {
	a = find(a);
    b = find(b);
 
    if (a > b)
        lst[a] = b;
    else lst[b] = a;
}

void FASTIO() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
}

int main() {
	cin >> n;
	for (int i = 0; i < 1003; i++) lst[i] = i;
    //v.reserve(n * (n-1) / 2); 
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
			if (i > j) {
				v.push_back({ a[i][j], i, j });
			}
		}
	}

	sort(v.begin(), v.end());
	long long res = 0;
    
	for (int i = 0; i < v.size(); i++) {
		int c = v[i][0];
		int px = v[i][1];
		int py = v[i][2];
		if (find(px) != find(py)) {
			merge(px, py);
			res += c;
		}
	}
	cout << res << '\n';
	return 0;
}