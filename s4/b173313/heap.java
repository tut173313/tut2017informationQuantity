void main(){
    //  ソートする行列(最初は０にしておく
    //int array[MAX_LENGTH+1] = { 0,4,2,5,6,1 };
    //  ソートする処理
    heap_sort(array,myTarget.length);
}
 
//  配列の成分の入れ替え
void swap(int m,int n)
{
    int tmp = suffixArray[m];
    suffixArray[m] = suffixArray[n];
    suffixArray[n] = tmp;
}
//  ヒープの要素を沈める処理。suffixArray[start]から、suffixArray[end]までを要素とする。
int downheap(int start,int end){
    int parent,child,r = 0, flag = 1;
    child = end;    //  子ノードのスタート位置
    //  末端の要素から、たどり、親要素よりも値が大きければ、入れ替える処理を繰り返す。
    while(flag == 1){
        //  親ノードの番号取得
        parent = start + (child - start) / 2;
        //  バイナリツリーの末端の最初が親よりも大きければ、入れ替える。
        if(suffixCompare(child, parent) == 1){
            swap(child,parent);
            r = 1;
        }
        //  iをデクリメント
        child--;
		if(parent > start)flag = 1;
    }  //  子ノードが、startの位置を超えてしまったら、終了
    return r;
}
 
//  ヒープソート
void heap_sort(int size)
{
    int i = 1;
    while(downheap(i,size)){
        i++;
    }
}