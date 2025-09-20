import SwiftUI

struct ContentView: View {
    var body: some View {
        TabView {
            // 載具
            PlaceholderView(title: "載具")
                .tabItem {
                    Image(systemName: "barcode.viewfinder")
                    Text("載具")
                }

            // 設定
            PlaceholderView(title: "設定")
                .tabItem {
                    Image(systemName: "gearshape")
                    Text("設定")
                }

            // 紀錄
            PlaceholderView(title: "紀錄")
                .tabItem {
                    Image(systemName: "doc.text")
                    Text("紀錄")
                }

            // 兌獎
            PlaceholderView(title: "兌獎")
                .tabItem {
                    Image(systemName: "gift")
                    Text("兌獎")
                }
        }
    }
}

struct PlaceholderView: View {
    let title: String
    var body: some View {
        VStack(spacing: 12) {
            Text("\(title) 功能")
                .font(.title2)
                .bold()
            Text("尚未開發")
                .foregroundColor(.secondary)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

// 預覽
#Preview {
    ContentView()
}
